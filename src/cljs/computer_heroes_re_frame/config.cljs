(ns computer-heroes-re-frame.config)

(def debug?
  ^boolean js/goog.DEBUG)

(def screen
  {:width 1024
   :height 768})

(def hero
  {:width 100
   :height 152})
