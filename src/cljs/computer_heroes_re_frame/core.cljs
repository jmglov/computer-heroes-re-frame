(ns computer-heroes-re-frame.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [computer-heroes-re-frame.events]
              [computer-heroes-re-frame.subs]
              [computer-heroes-re-frame.views :as views]
              [computer-heroes-re-frame.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (set! (.-onkeydown js/window)
        #(re-frame/dispatch [:key-pressed (.-keyCode %)]))
  (dev-setup)
  (mount-root))
