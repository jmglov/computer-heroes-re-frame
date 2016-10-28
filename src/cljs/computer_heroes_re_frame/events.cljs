(ns computer-heroes-re-frame.events
  (:require [re-frame.core :as re-frame]
            [computer-heroes-re-frame.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :key-pressed
 (fn  [db [_ code]]
   (if-let [key-name (condp = code
                       37 "left"
                       38 "up"
                       39 "right"
                       40 "down"
                       nil)]
     (assoc db :name key-name)
     db)))
