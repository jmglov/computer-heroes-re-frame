(ns computer-heroes-re-frame.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div {:style {:position "relative"
                     :width "1024px"
                     :height "400px"}}
       [:div @name " pressed"]
       [:div [:img {:src "img/2tone.jpg"
                    :width "100px"
                    :style {:position "absolute"
                            :bottom "0px"}}]]])))
