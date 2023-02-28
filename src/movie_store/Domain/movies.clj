(ns movie-store.Domain.movies
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
    ;[clojure.java.jdbc.sql :as sql]
            ))

(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/clojure_ecommerce"
               :user "root"
               :password ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(def now (str (java.sql.Timestamp. (System/currentTimeMillis))))

(defn allMovies []
  (jdbc/query mysql-db
              ["SELECT * FROM movies m"]))
(defn home []
  (jdbc/query mysql-db
              ["SELECT * FROM movies m"]))

;(println (allMovies))