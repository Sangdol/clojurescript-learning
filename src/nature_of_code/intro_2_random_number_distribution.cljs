;;
;; Random Number Distribution
;; https://natureofcode.com/book/introduction/
;;
(ns nature-of-code.intro-2-random-number-distribution
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 5)
  (vec (repeat 10 0)))

(defn update [state]
  (update-in state [(rand-int 10)] inc))

(defn draw [state]
  (q/background 240)
  (doseq [[i n] (map-indexed vector state)]
    (let [w (/ (q/width) (count state))]
      (q/rect (* w i)
              (- (q/height) n)
              w
              n))))

(q/defsketch random-number-distribution
             :size [200 100]
             :setup setup
             :draw draw
             :update update
             :middleware [m/fun-mode])

