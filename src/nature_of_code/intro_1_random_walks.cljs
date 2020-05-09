;;
;; Random Walks
;; https://natureofcode.com/book/introduction/
;;
(ns nature-of-code.intro-1-random-walks
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/background 240)
  (q/frame-rate 5)
  {:x (/ (q/width) 2) :y (/ (q/height) 2)})

(defn update [state]
  (letfn [(rand-update [n]
            (+ n (- (rand-int 3) 1)))]
    (-> state
      (update-in [:x] rand-update)
      (update-in [:y] rand-update))))

(defn draw [state]
  (q/stroke 0)
  (q/point (:x state) (:y state)))


(q/defsketch random-walks
             :size [100 100]
             :setup setup
             :draw draw
             :update update
             :middleware [m/fun-mode])
