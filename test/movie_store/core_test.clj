(ns movie-store.core-test
  (:require [clojure.test :refer :all]
            [movie-store.core :refer :all]
            [movie-store.Domain.actors :refer :all]
            [movie-store.Domain.producers :refer :all]
            [movie-store.Domain.cinemas :refer :all]
            [midje.sweet :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(midje.sweet/facts "Najjednostavniji test" (+ 1 2) => 3)

(midje.sweet/facts "test actors"
                   (movie-store.Domain.actors/get 1) => {:bio "This is the Bio of the five actor"
                                                         :fullname "Actor 5"
                                                         :id 1
                                                         :profilepictureurl "http://dotnethow.net/images/actors/actor-5.jpeg"}
                   (movie-store.Domain.actors/get 2) => {:bio "This is the Bio of the fourth actor"
                                                         :fullname "Actor 4"
                                                         :id 2
                                                         :profilepictureurl "http://dotnethow.net/images/actors/actor-4.jpeg"}
                   (movie-store.Domain.actors/get 3) => {:bio "This is the Bio of the third actor"
                                                         :fullname "Actor 3"
                                                         :id 3
                                                         :profilepictureurl "http://dotnethow.net/images/actors/actor-3.jpeg"}
                   (movie-store.Domain.actors/get 4) => {:bio "This is the Bio of the second actor"
                                                         :fullname "Actor 2"
                                                         :id 4
                                                         :profilepictureurl "http://dotnethow.net/images/actors/actor-2.jpeg"}
                   (movie-store.Domain.actors/get 5) => {:bio "This is the Bio of the first actor"
                                                         :fullname "Actor 1"
                                                         :id 4
                                                         :profilepictureurl "http://dotnethow.net/images/actors/actor-1.jpeg"})

(midje.sweet/facts "test producers"
                   (movie-store.Domain.producers/getProducer 1) => {:bio "This is the Bio of the five producer"
                                                                    :fullname "Producer 5"
                                                                    :id 5
                                                                    :profilepictureurl "http://dotnethow.net/images/producers/producer-5.jpeg"}
                   (movie-store.Domain.producers/getProducer 2) => {:bio "This is the Bio of the fourth producer"
                                                                    :fullname "Producer 4"
                                                                    :id 2
                                                                    :profilepictureurl "http://dotnethow.net/images/producers/producer-4.jpeg"}
                   (movie-store.Domain.producers/getProducer 3) => {:bio "This is the Bio of the third producer"
                                                                    :fullname "Producer 3"
                                                                    :id 3
                                                                    :profilepictureurl "http://dotnethow.net/images/producers/producer-3.jpeg"}
                   (movie-store.Domain.producers/getProducer 4) => {:bio "This is the Bio of the second producer"
                                                                    :fullname "Producer 2"
                                                                    :id 4
                                                                    :profilepictureurl "http://dotnethow.net/images/producers/producer-2.jpeg"}
                   (movie-store.Domain.producers/getProducer 5) => {:bio "This is the Bio of the first producer"
                                                                    :fullname "Producer 1"
                                                                    :id 5
                                                                    :profilepictureurl "http://dotnethow.net/images/producers/producer-1.jpeg"})

(midje.sweet/facts "test cinemas"
                   (movie-store.Domain.cinemas/getCinema 1) => {:description "This is the description of the first cinema"
                                                                :id 1
                                                                :logo "http://dotnethow.net/images/cinemas/cinema-1.jpeg"
                                                                :name "Cinema 1"}
                   (movie-store.Domain.cinemas/getCinema 2) => {:description "This is the description of the second cinema"
                                                                :id 2
                                                                :logo "http://dotnethow.net/images/cinemas/cinema-2.jpeg"
                                                                :name "Cinema 2"}
                   (movie-store.Domain.cinemas/getCinema 3) => {:description "This is the description of the third cinema"
                                                                :id 3
                                                                :logo "http://dotnethow.net/images/cinemas/cinema-3.jpeg"
                                                                :name "Cinema 3"}
                   (movie-store.Domain.cinemas/getCinema 4) => {:description "This is the description of the fourth cinema"
                                                                :id 4
                                                                :logo "http://dotnethow.net/images/cinemas/cinema-4.jpeg"
                                                                :name "Cinema 4"}
                   (movie-store.Domain.cinemas/getCinema 5) => {:description "This is the description of the five cinema"
                                                                :id 5
                                                                :logo "http://dotnethow.net/images/cinemas/cinema-5.jpeg"
                                                                :name "Cinema 5"})

