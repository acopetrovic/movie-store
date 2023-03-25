(ns movie-store.Domain.producers
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

(defn producer []
  (jdbc/query mysql-db
              ["SELECT * FROM producers p"]))

(defn getProducer [id]
  (first (jdbc/query mysql-db
                     ["SELECT * FROM producers WHERE id = ?" id])))

(defn updateProducer [id params]
  (jdbc/update! mysql-db :producers params (sql/where {:id id})))

(defn removeProducer [id]
  (jdbc/execute! mysql-db
                 ["DELETE FROM producers WHERE id = ?" id]))
(defn insertProducer
  [params]
  (jdbc/insert! mysql-db :producers params))

(defn statisticProducer []
  (let [result (jdbc/query mysql-db ["SELECT COUNT(*) FROM producers"])]
    (-> result
        first
        vals
        first)))