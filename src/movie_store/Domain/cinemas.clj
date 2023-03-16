(ns movie-store.Domain.cinemas
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            ))


(def mysql-db {
               :subprotocol "mysql"
               :subname "//localhost:3306/clojure_ecommerce"
               :user "root"
               :password ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(def now (str (java.sql.Timestamp. (System/currentTimeMillis))))

(defn cinema []
  (jdbc/query mysql-db
              ["SELECT * FROM cinemas c"]))
(defn getCinema [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM cinemas WHERE id = ?" id])))

(defn updateCinema [id params]
  (jdbc/update! mysql-db :cinemas params (sql/where {:id id})))

(defn removeCinema [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM cinemas WHERE id = ?" id]))

(defn insertCinema
  [params]
  (jdbc/insert! mysql-db :cinemas params))