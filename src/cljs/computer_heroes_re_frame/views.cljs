(ns computer-heroes-re-frame.views
  (:require [computer-heroes-re-frame.config :as config]
            [re-frame.core :as re-frame]))

(defn- px [val]
  (str val "px"))

(defn hero []
  (let [hero (re-frame/subscribe [:hero])
        {:keys [width height]} config/hero]
    (fn []
      [:img {:src "img/2tone.jpg"
             :width (px width)
             :height (px height)
             :style {:position "absolute"
                     :bottom "0px"}}])))

(defn screen []
  (let [{:keys [width height]} config/screen]
    [:div {:style {:position "relative"
                   :width (px width)
                   :height (px height)}}
     [hero]]))

(defn debug-msg []
  (let [debug-msg (re-frame/subscribe [:debug-msg])]
    (fn []
      [:div {:style {:font-style "italic"}} @debug-msg])))

(defn main-panel []
  (fn []
    [:div
     [:h1 "Computer Heroes"]
     [screen]
     [debug-msg]]))
