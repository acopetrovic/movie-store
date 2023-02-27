(ns movie-store.Controller.controller
  (:require [clostache.parser :as clostache]
            [movie-store.Domain.movies :as movies-domain]
            [movie-store.Domain.actors :as actors-domain]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))



(defn index []
  (render-template "index" {}))

(defn AllMovies []
  (render-template "movie" {:movies (movies-domain/allMovies)}))

(defn Actor []
  (render-template "actor" {:actor (actors-domain/actor)}))

(defn home []
  (render-template "homepage" {:movies (movies-domain/home)}) )
