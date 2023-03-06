(ns movie-store.core
  (:use compojure.core)
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [ring.adapter.jetty :refer [run-jetty] :as jetty]
            [ring.util.response :as resp]
            [compojure.handler :as handler]
            [ring.middleware.basic-authentication :refer :all]
            [movie-store.Controller.controller :as controller]
            [movie-store.Domain.actors :as actors-domain]
            [movie-store.Domain.producers :as producers-domain]
            [movie-store.Domain.cinemas :as cinemas-domain]

            ))

(def movies [{:id 1 :title "The Shawshank Redemption" :price 10.99}
             {:id 2 :title "The Godfather" :price 12.99}
             {:id 3 :title "The Dark Knight" :price 14.99}])
;(get (first movies) :title)

(defn total-name [movies]
  (map :title movies))
(total-name movies)
;(doseq [movie movies]
; (println (:title movie)))

(defn total-price [movies]
  (reduce #(+ %1 (get %2 :price 0)) 0 movies))
(total-price movies)





(defn movie-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (html [:head [:link {:rel "stylesheet" :href "{{webjars/path \"bootstrap/4.6.1/css/bootstrap.min.css\"}}"}]
                   [:link {:rel "stylesheet" :href "~/css/site.css"}]
                   [:link {:rel "stylesheet" :href "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"}]
                   [:script {:src "https://kit.fontawesome.com/a076d05399.js"}]
                   [:body {:style "background-color:white; container:fluid;min-height:100vh;line-height:1.5"} [:nav {:style "background-color:#0082e6; height:80px; width:100%"}
                                                                                                               [:input#check> {:type "checkbox" :style "display:none; max-width: 952px;"}]
                                                                                                               [:label {:for "check" :style "font-size:30px; color:white; float:right; margin-right:40px;padding:20px;display:none;max-width:952px"}
                                                                                                                [:i.fas.fa-bars]]
                                                                                                               [:label {:style "color:white; font-size:35px; padding: 0 100px; line-height: 50px"} "eTickets"
                                                                                                                [:ul {:style "float:right; margin-right:20px; font-size:17px; padding:7px 13px; text-transform:uppercase"}
                                                                                                                 [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/movies" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} [:i.bi.bi-film {:style "margin:0 3px"}] "Movies"]]
                                                                                                                 [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/actors" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} [:i.bi.bi-person-square {:style "margin:0 3px"}] "Actors"]]
                                                                                                                 [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/producers" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} [:i.bi.bi-headset {:style "margin:0 3px"}] "Producers"]]
                                                                                                                 [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/cinemas" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} [:i.bi.bi-camera-reels {:style "margin:0 3px"}] "Cinemas"]]]]]
                    [:div
                     [:div {:style "display:flex;align-items:center;width:100%"}
                      [:div {:style "padding:20px"}
                       [:div {:style "max-width:100%; background-color:powderblue;"}
                        [:div
                         [:div {:style "background-color:#0082e6"}
                          [:div {:style "color:white;"}
                           [:p] [:h2 {:style "padding-left:20px; line-height:80px;"} "Cold Soles"
                                 [:a {:href "#" :style "float:right"} [:i.bi.bi-pencil-square {:style "padding-right:20px;color:white "}]]]
                           ]]
                         [:div {:style "padding-left:10px;display:flex;"}
                          [:img {:src "http://dotnethow.net/images/movies/movie-8.jpeg" :width "50%" :height "100%" :alt "Cold Soles"}]
                          [:div
                           [:div {:style "padding:10px; width:100%"}
                            [:p "This is the Cold Soles movie description"]
                            [:p [:b "Cinema:"] "Cinema 1"]
                            [:p [:b "Category:"] "Drama"]
                            [:p [:b "Start Date:"] "23 Jan 23"]
                            [:p [:b "End Date:"] "09 Feb 23"]
                            [:p [:b "Status:"]]]]]

                         [:div
                          [:div {:style "background-color:#0082e6;"}
                           [:p
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"} [:a {:href "/Orders/AddItemToShoppingCart/6" :style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"} [:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]]]]

                         ]]]
                      [:div {:style "padding:20px"}
                       [:div {:style "max-width:100%;background-color:powderblue;"}
                        [:div
                         [:div {:style "background-color:#0082e6"}
                          [:div {:style "color:white"}
                           [:p] [:h2 {:style "padding-left:20px; line-height:80px;"} "Ghost"
                                 [:a {:href "#" :style "float:right"} [:i.bi.bi-pencil-square {:style "padding-right:20px;color:white "}]]]]]
                         [:div {:style "padding-left:10px;display:flex;"}
                          [:img {:src "http://dotnethow.net/images/movies/movie-4.jpeg" :width "50%" :height "100%" :alt "Ghost"}]
                          [:div
                           [:div {:style "padding:10px; width:100%"}
                            [:p "This is the Ghost movie description"]
                            [:p [:b "Cinema:"] "Cinema 3"]
                            [:p [:b "Category:"] "Horror"]
                            [:p [:b "Start Date:"] "10 Jan 23"]
                            [:p [:b "End Date:"] "28 Feb 23"]
                            [:p [:b "Status:"]]]]]

                         [:div
                          [:div {:style "background-color:#0082e6;"}
                           [:p
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"} [:a {:href "/Orders/AddItemToShoppingCart/6" :style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"} [:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]
                            ]]]]]]

                      [:div {:style "padding:20px"}
                       [:div {:style "max-width:100%;background-color:powderblue;"}
                        [:div
                         [:div {:style "background-color:#0082e6"}
                          [:div {:style "color:white"}
                           [:p] [:h2 {:style "padding-left:20px; line-height:80px;"} "Scoob"
                                 [:a {:href "#" :style "float:right"} [:i.bi.bi-pencil-square {:style "padding-right:20px;color:white "}]]]]]
                         [:div {:style "padding-left:10px;display:flex;"}
                          [:img {:src "http://dotnethow.net/images/movies/movie-7.jpeg" :width "50%" :height "100%" :alt "Ghost"}]
                          [:div
                           [:div {:style "padding:10px; width:100%"}
                            [:p "This is the Scoob movie description"]
                            [:p [:b "Cinema:"] "Cinema 2"]
                            [:p [:b "Category:"] "Cartoon"]
                            [:p [:b "Start Date:"] "08 Jan 23"]
                            [:p [:b "End Date:"] "22 Feb 23"]
                            [:p [:b "Status:"]]]]]

                         [:div
                          [:div {:style "background-color:#0082e6;"}
                           [:p
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"} [:a {:href "/Orders/AddItemToShoppingCart/6" :style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"} [:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]
                            ]]]]]]

                      ]]]])})


(defroutes public-routes
           ;(GET "/movies" [] movie-handler)
           ;(GET "/actors" [] actor/actor-handler)
           ;(GET "/producers" [] producer/producer-handler)
           ;(GET "/cinemas" [] cinema/cinema-handler)
           (GET "/index" [] (controller/index))
           (route/resources "/")
           (GET "/movies" [] (controller/AllMovies))
           (route/resources "/")
           (GET "/homepage" [] (controller/home))
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





