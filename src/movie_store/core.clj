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
  (html (format "
  <!DOCTYPE html>
  <html>
  <head>
    <title>Movie Store</title>
     </head>
  <body>
    <h1>Movie Title</h1>
    <img src=\"https://st4.depositphotos.com/1533030/22618/v/1600/depositphotos_226181858-stock-illustration-cinema-poster-retro-film-projector.jpg\" width=\"300px\"alt=\"Movie Poster\">
    <h2>Synopsis</h2>
    <p>A brief summary of the movie's plot.</p>
    <h2>Cast</h2>
    <ul>
      <li>Actor 1</li>
      <li>Actor 2</li>
      <li>Actor 3</li>
    </ul>
    <h2>Director</h2>
    <p>Director's name</p>
    <h2>Release Date</h2>
    <p>The movie's release date</p>
    <h1>Total price of all movies is %f</h1>
  </body>
  </html>" data)))
(total-price-view 30)

;(defn handler [request]
;(case (:uri request)
; "/price"
;{:status  200
; :headers {"Content-type" "text/html"}
; :body    (total-price-view 30)} ) )
(total-price-view (total-price movies))

(defroutes handler
           (GET "/price" [] (total-price-view (total-price movies))))

(jetty/run-jetty (fn [req] (handler req)) {:port 4001 :join? false})