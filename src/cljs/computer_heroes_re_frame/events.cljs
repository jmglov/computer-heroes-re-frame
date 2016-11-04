(ns computer-heroes-re-frame.events
  (:require [computer-heroes-re-frame.config :as config]
            [computer-heroes-re-frame.db :as db]
            [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(def min-val {:x 0, :y 0})
(def max-val {:x (- (:width config/screen) (:width config/hero))
              :y (- (:height config/screen) (:height config/hero))})

(defn- within-screen [axis val]
  (let [min (min-val axis)
        max (max-val axis)]
    (cond
      (< val min) min
      (> val max) max
      true val)))

(def keymap
  {37 {:name "left"
       :path [:hero :x]
       :update-fn #(within-screen :x (- % (:speed config/hero)))}
   38 {:name "up"
       :path [:hero :y]
       :update-fn #(within-screen :y %)}
   39 {:name "right"
       :path [:hero :x]
       :update-fn #(within-screen :x (+ % (:speed config/hero)))}
   40 {:name "down"
       :path [:hero :y]
       :update-fn #(within-screen :y %)}})

(re-frame/reg-event-db
 :key-pressed
 (fn  [db [_ code]]
   (if-let [key (keymap code)]
     (-> db
         (assoc :debug-msg (str (:name key) " pressed"))
         (update-in (:path key) (:update-fn key)))
     db)))
