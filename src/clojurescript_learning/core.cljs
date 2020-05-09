(ns clojurescript-learning.core
  (:require [clojure.browser.repl :as repl]
            [clojurescript-learning.js-test :as js]
            [clojurescript-learning.jayq-jquery-test :as jq]
            [clojurescript-learning.quil-test :as q]
            [nature-of-code.intro-1-random-walks :as ni1]))

(defonce conn
  (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

;(println "Hello world!")
