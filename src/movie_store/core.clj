(ns movie-store.core

  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty] :as jetty]
            [ring.util.response :as resp]
            [compojure.handler :as handler]
            [movie-store.Controller.controller :as controller]
            [movie-store.Domain.actors :as actors-domain]
            [movie-store.Domain.producers :as producers-domain]
            [movie-store.Domain.cinemas :as cinemas-domain]
            ))

(defroutes public-routes
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/movies" [] (controller/AllMovies))
           (route/resources "/")
           (GET "/actor" [] (controller/Actor))
           (route/resources "/")
           (GET "/producer" [] (controller/Producer))
           (route/resources "/")
           (GET "/cinema" [] (controller/Cinema))
           (route/resources "/")
           (GET "/edit" [] (controller/Edit []))
           (route/resources "/")

           ;Actors
           (GET "/Domain/actors/:id/update" [id]
             (controller/Edit id))

           (POST "/Domain/actors/:id/update" [& params]
             (do (actors-domain/updateActors (:id params) params)
                 (resp/redirect "/actor")))

           (GET "/Domain/actors/:id/remove" [id]
             (do (actors-domain/removeActor id)
                 (resp/redirect "/actor")))

           (POST "/Domain/actors/insert" [& params]
             (do (actors-domain/insertActor params)
                 (resp/redirect "/actor")))
           ;Producers
           (GET "/Domain/producers/:id/update" [id]
             (controller/EditProducer id))

           (POST "/Domain/producers/:id/update" [& params]
             (do (producers-domain/updateProducer (:id params) params)
                 (resp/redirect "/producer")))

           (GET "/Domain/producers/:id/remove" [id]
             (do (producers-domain/removeProducer id)
                 (resp/redirect "/producer")))

           (POST "/Domain/producers/insert" [& params]
             (do (producers-domain/insertProducer params)
                 (resp/redirect "/producer")))
           ;Cinemas
           (GET "/Domain/cinemas/:id/update" [id]
             (controller/EditCinema id))

           (POST "/Domain/cinemas/:id/update" [& params]
             (do (cinemas-domain/updateCinema (:id params) params)
                 (resp/redirect "/cinema")))

           (GET "/Domain/cinemas/:id/remove" [id]
             (do (cinemas-domain/removeCinema id)
                 (resp/redirect "/cinema")))

           (POST "/Domain/cinemas/insert" [& params]
             (do (cinemas-domain/insertCinema params)
                 (resp/redirect "/cinema")))
           )

(defroutes app-routes
           public-routes
           (route/not-found "404. Page not found"))

(def app
  (handler/site app-routes))

(jetty/run-jetty (fn [req] (public-routes req)) {:port 4003 :join? false})





