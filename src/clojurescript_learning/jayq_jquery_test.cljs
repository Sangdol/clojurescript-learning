#_("
  jayq https://github.com/ibdknox/jayq
")
(ns clojurescript-learning.jayq-jquery-test
  (:use [jayq.core :only [$ on text prop trigger]]))

(println "Hello Jayq!")

#_("

  1. Bind a click event to an anchor tag.
  2. Get the id of the tag and set it inside a div.
")

(def $click-me ($ :#click-me))

(defn on-click-me []
  (do
    (this-as this
      (text ($ :.click-result) (->
                                 ($ this)
                                 (prop :id)))
      nil)))

(on $click-me :click on-click-me)
(trigger $click-me :click)
