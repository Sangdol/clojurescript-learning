;;
;; Random Walks
;; https://natureofcode.com/book/introduction/
;;
(ns nature-of-code.intro-1-random-walks
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn rand-update [rand-func seed]
  (fn [n]
    (+ n (rand-func seed))))

(defn basic-walks []
  (- (rand-int 3) 1))

(defn levy-flight-walks []
  (if (< (rand) 0.1)
    (- (rand-int 200) 100)
    (basic-walks)))

(defn montecarlo-walks []
  (loop [a (rand) b (rand)]
    (if (> a b)
      (recur (rand) (rand))
      (* b (basic-walks)))))

(defn pelin-noise-walks [seed]
  (- (* (q/noise seed) 4) 2))


(defn setup []
  (q/background 240)
  (q/frame-rate 5)
  {:x (/ (q/width) 2) :y (/ (q/height) 2) :xt 0 :yt 10000})

(defn update [rand-func]
  (fn [state]
    (-> state
        (update-in [:x] (rand-update rand-func (:xt state)))
        (update-in [:y] (rand-update rand-func (:yt state)))
        (update-in [:xt] (fn [] (+ (:xt state) 0.1)))
        (update-in [:yt] (fn [] (+ (:yt state) 0.1))))))

(defn draw [state]
  (q/stroke 0)
  (q/point (:x state) (:y state)))


(q/defsketch random-walks-container
             :size [100 100]
             :setup setup
             :draw draw
             :update (update basic-walks)
             :middleware [m/fun-mode])

(q/defsketch levy-flight-container
             :size [100 100]
             :setup setup
             :draw draw
             :update (update levy-flight-walks)
             :middleware [m/fun-mode])

(q/defsketch montecarlo-container
             :size [100 100]
             :setup setup
             :draw draw
             :update (update montecarlo-walks)
             :middleware [m/fun-mode])

(q/defsketch pelin-noise-container
             :size [100 100]
             :setup setup
             :draw draw
             :update (update pelin-noise-walks)
             :middleware [m/fun-mode])
