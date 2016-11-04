(ns computer-heroes-re-frame.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :debug-msg
 (fn [db]
   (:debug-msg db)))

(re-frame/reg-sub
 :hero
 (fn [db]
   (:hero db)))
