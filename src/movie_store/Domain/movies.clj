(ns movie-store.Domain.movies
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            ))

(def mysql-db {
               :subprotocol           "mysql"
               :subname               "//localhost:3306/clojure_ecommerce"
               :user                  "root"
               :password              ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(defn allMovies []
  (jdbc/query mysql-db
              ["SELECT * FROM movies m"]))

(defn statisticMovie []
  (let [result (jdbc/query mysql-db ["SELECT COUNT(*) FROM movies"])]
    (-> result
        first
        vals
        first)))

(defn avg-price []
  (let [result (jdbc/query mysql-db ["SELECT AVG(price) FROM movies"])]
    (-> result
        first
        vals
        first)))