;;
;; Gaussian Distribution
;; https://natureofcode.com/book/introduction/
;;
(ns nature-of-code.intro-3-gaussian-distribution
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/background 240)
  (q/frame-rate 3))
  ;(q/stroke 0)
  ;(q/stroke-weight 10)
  ;(q/point 100 50))

(defn update [])

(defn draw []
  (q/stroke 0 10)
  (q/stroke-weight 10)
  (let [r (q/random-gaussian)
        sd 30
        mean (/ (q/width) 2)]
    (q/point (+ (* r sd) mean) (/ (q/height) 2))))

(q/defsketch gaussian-distribution
             :size [200 100]
             :setup setup
             :draw draw
             :update update
             :middleware [m/fun-mode])

