;;
;; Gaussian Distribution
;; https://natureofcode.com/book/introduction/
;;
(ns nature-of-code.intro-3-gaussian-distribution
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(def FRAME_COUNT 3000)

(defn setup []
  (q/background 240)
  (q/color-mode :hsl 360 100 100 100)
  (q/frame-rate 60)
  {:current-frame 0})

(defn update [state]
  (if (= (:current-frame state) FRAME_COUNT)
    (do
      (js/console.log "Finished")
      (q/no-loop)))
  (update-in state [:current-frame] inc))

(defn rg [sd mean]
  "random gaussian"
  (+ (* (q/random-gaussian) sd) mean))

(defn draw []
  ;; https://tylerxhobbs.com/essays/2016/working-with-color-in-generative-art
  ;; http://colorizer.org/
  (q/stroke-weight 3)
  (let [x_mean (/ (q/width) 2)
        y_mean (/ (q/height) 2)
        x (rg 30 x_mean)
        y (rg 30 y_mean)]
    (q/stroke (rg 100 (+ x y)) 30 50 30)
    (q/point x y)))

(q/defsketch gaussian-distribution
             :size [200 200]
             :setup setup
             :draw draw
             :update update
             :middleware [m/fun-mode])

