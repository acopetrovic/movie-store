(ns movie-store.actors
  (:require [hiccup.core :refer [html]]))
(defn actor-handler [request]
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
                                                                                                                 [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/cinemas" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} [:i.bi.bi-camera-reels {:style "margin:0 3px"}] "Cinemas" ]]]]]
                    [:div
                     [:div
                      [:table {:style "margin:25px 0;border-collapse:collapse;width:80%;text-align:center;border-top:1px solid #e0e0d1;border-bottom:1px solid #e0e0d1;margin-left:auto;margin-right:auto"}
                       [:thead {:style "border-bottom:1px solid #e0e0d1"}
                        [:tr {:style "padding:20px;"}
                         [:th [:h3 "Profile Picture"]]
                         [:th [:h3 "Full Name"]]
                         [:th [:h3 "Biography"]]
                         [:th [:h3 "Actions"]]]]
                       [:tbody
                        [:tr {:style "font-size:18px"}
                         [:td [:img.rounded-circle {:style "max-width:200px;clip-path:circle()" :src "http://dotnethow.net/images/actors/actor-1.jpeg" :alt "Actor 1"}]]
                         [:td "Actor 1"]
                         [:td "This is the biography of first actor"]
                         [:td
                          [:a {:style "padding:7px 13px;border-radius:7px;margin:0 5px;border:0.5px solid" :href "/Edit" :asp-action "Edit" } [:i.bi.bi-pencil-square] "Edit"]
                          [:a {:style "padding:7px 13px;border-radius:7px;margin:0 5px;border:0.5px solid" :href "/Details" :asp-action "Details" } [:i.bi.bi-eye] "Details"]
                          [:a {:style "padding:7px 13px;border-radius:7px;background-color:#DC3535;margin:0 5px;color:white" :href "/Delete" :asp-action "Delete" } [:i.bi.bi-trash] "Delete"]]]]]]]
                    ]])})