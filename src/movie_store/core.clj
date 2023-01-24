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








