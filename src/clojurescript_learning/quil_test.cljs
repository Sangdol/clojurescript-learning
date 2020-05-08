(ns clojurescript-learning.quil-test
  (:require [quil.core :as q :include-macros true]))

(println "Hello Quil!")

(defn draw []
  (q/background 240)
  (q/line [0 0] [100 100])
  (q/no-loop))

(q/defsketch hello-quil
             :size [100 100]
             :draw draw)

