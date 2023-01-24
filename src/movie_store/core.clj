(ns movie-store.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.adapter.jetty :refer [run-jetty] :as jetty]
            ))

(def movies [{:id 1 :title "The Shawshank Redemption" :price 10.99}
             {:id 2 :title "The Godfather" :price 12.99}
             {:id 3 :title "The Dark Knight" :price 14.99}])

(defn total-price [movies]
  (reduce #(+ %1 (get %2 :price 0)) 0 movies))
(total-price movies)

(defn total-price-view [data]
  (html (format "<h1>Total price of all movies is %d</h1>" data)))
(total-price-view 30)

(defn handler [request]
  (case (:uri request)
    "/price"
    {:status  200
     :headers {"Content-type" "text/html"}
     :body    (total-price-view 20)}))

(defroutes handler
         (GET "/price" [] (total-price-view (total-price movies))))

(jetty/run-jetty (fn [req] (handler req)) {:port 4000 :join? false})