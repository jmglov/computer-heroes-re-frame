(ns computer-heroes-re-frame.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [computer-heroes-re-frame.core-test]))

(doo-tests 'computer-heroes-re-frame.core-test)
