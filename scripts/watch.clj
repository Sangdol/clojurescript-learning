(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'clojurescript-learning.core
   :output-to "out/clojurescript_learning.js"
   :output-dir "out"})
