(ns movie-store.Controller.controller
  (:require [clostache.parser :as clostache]
            [movie-store.Domain.movies :as movies-domain]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "pages/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))



(defn index []
  (render-template "index" {}))

(defn AllMovies []
  (render-template "movie" {:movies (movies-domain/allMovies)}))

(defn home []
  (render-template "homepage" {:movies (movies-domain/home)}) )
