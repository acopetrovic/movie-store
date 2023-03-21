(ns movie-store.Domain.actors
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            ))




(def mysql-db {
               :subprotocol           "mysql"
               :subname               "//localhost:3306/clojure_ecommerce"
               :user                  "root"
               :password              ""
               :zeroDateTimeBehaviour "convertToNull"
               })

(defn actor []
  (jdbc/query mysql-db
              ["SELECT * FROM actors a"]))
(defn get [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM actors WHERE id = ?" id])))

(defn updateActors [id actors]
   (jdbc/update! mysql-db :actors actors (sql/where {:id id})))

(defn removeActor [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM actors WHERE id = ?" id]))

(defn insertActor
  [params]
  (jdbc/insert! mysql-db :actors params))