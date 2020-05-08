#_("
  jayq https://github.com/ibdknox/jayq
")
(ns clojurescript-learning.jayq-jquery-test
  (:require [jayq.core :as j]))

(println "Hello Jayq!")

#_("
  1. Bind a click event to an anchor tag.
  2. Get the id of the tag and set it inside a div.
")

(def $click-me (j/$ :#click-me))

(defn on-click-me []
  (do
    (this-as this
      (j/text (j/$ :.click-result) (->
                                     (j/$ this)
                                     (j/prop :id)))
      nil)))

(j/on $click-me :click on-click-me)
(j/trigger $click-me :click)
