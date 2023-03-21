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