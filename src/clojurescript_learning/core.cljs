(ns clojurescript-learning.core
  (:require [clojure.browser.repl :as repl]
            [clojurescript-learning.js-test :as js]
            [clojurescript-learning.jayq-jquery-test :as jq]
            [clojurescript-learning.quil-test :as q]))

(defonce conn
  (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello world!")
