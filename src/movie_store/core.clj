(ns movie-store.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.adapter.jetty :refer [run-jetty] :as jetty]
            [ring.util.response :as response]
            ))

(def movies [{:id 1 :title "The Shawshank Redemption" :price 10.99}
             {:id 2 :title "The Godfather" :price 12.99}
             {:id 3 :title "The Dark Knight" :price 14.99}])

(def producers [])
(def actors [])
(defn cinemas [])
(defn total-price [movies]
  (reduce #(+ %1 (get %2 :price 0)) 0 movies))
(total-price movies)

(defn total-price-view [data]
  (html (format "
  <!DOCTYPE html>
  <html>
  <head>
  <nav class=\"navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3\">
    <title>Movie Store</title>
    <nav class=\"navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3\">
     </head>
  <body>
    <h1>Movie Title</h1>
    <img src=\"https://st4.depositphotos.com/1533030/22618/v/1600/depositphotos_226181858-stock-illustration-cinema-poster-retro-film-projector.jpg\" width=\"300px\"alt=\"Movie Poster\">
    <h2>Synopsis</h2>
    <p>A brief summary of the movie's plot.</p>
    <h2>Cast</h2>
    <ul>
      <li>Actor 1</li>
      <li>Actor 2</li>
      <li>Actor 3</li>
    </ul>
    <h2>Director</h2>
    <p>Director's name</p>
    <h2>Release Date</h2>
    <h3 style=\"color:blue;\">A Blue Heading</h3>
    <p>The movie's release date</p>
    <button class=\"btn btn-primary\">Click me</button>
    <h1>Total price of all movies is</h1>
  </body>
  </html>" data)))
(total-price-view 30)


;(defn handler [request]
;(case (:uri request)
; "/price"
;{:status  200
; :headers {"Content-type" "text/html"}
; :body    (total-price-view 30)} ) )
(total-price-view (total-price movies))

(defn bootstrap-handler [request]
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
                                                               [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "/movies" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} "Movies"]]
                                                               [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "#" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} "Actors"]]
                                                               [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "#" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} "Producers"]]
                                                               [:li {:style "display:inline-block; line-height:40px; margin:0 5px"} [:a {:href "#" :style "background-color:#1b9bff;transition:0.5s;padding:7px 13px;border-radius:3px; color:white;"} "Cinemas"]]]]]
                    [:div
                     [:div {:style "display:flex;align-items:center;width:100%"}
                      [:div {:style "padding:20px"}
                       [:div {:style "max-width:100%; background-color:powderblue;"}
                        [:div
                         [:div {:style "background-color:#0082e6"}
                          [:div {:style "color:white;"}
                           [:p] [:h2 {:style "padding-left:20px; line-height:80px;"} "Cold Soles"
                                 [:a {:href "#":style "float:right"} [:i.bi.bi-pencil-square {:style "padding-right:20px;color:white "}]]]
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
                            [:p [:b "Status:"]]]] ]

                         [:div
                          [:div {:style "background-color:#0082e6;"}
                           [:p
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"}[:a {:href "/Orders/AddItemToShoppingCart/6":style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"}[:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]]]]

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
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"}[:a {:href "/Orders/AddItemToShoppingCart/6":style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"}[:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]
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
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;"}[:a {:href "/Orders/AddItemToShoppingCart/6":style "background-color:#048A5B;padding:7px 20px;border-radius:20px;font-size:20px;color:white"} [:i.bi.bi-cart-plus] "Add to Cart"]]
                            [:p {:style "display:inline-block; line-height:70px; margin:0 5px;float:right"}[:a {:href "/Movies/Details/6" :style "background-color:#1b9bff;padding:7px 20px;border-radius:20px;font-size:20px;color:white;"} [:i.bi.bi-eye-fill] "Show Details"]]
                            ]]]]]]

                      ]]]])})

;display:flex;flex-direction:row;flex-wrap:wrap;
;[:li {:style "display:inline-block; line-height:50px; margin:0 5px"}[:a {:href "/Movies/Details/6" :style "float:right;margin-right:20px;color:white;font-size:20px;background-color:#1b9bff;"} [:i.bi.bi-eye-fill] "Show Details"]]
;                             [:li {:style "display:inline-block; line-height:50px; margin:0 5px"}[:a {:href "/Orders/AddItemToShoppingCart/6":style "display:inline-block;margin-left:20px;color:white;font-size:20px;background-color:#048A5B"} [:i.bi.bi-cart-plus] "Add to Cart"]]]]]]]]

(defroutes handler
           (GET "/price" [] (total-price-view (total-price movies)))
           (GET "/movies" [] bootstrap-handler))




(jetty/run-jetty (fn [req] (handler req)) {:port 4003 :join? false})
