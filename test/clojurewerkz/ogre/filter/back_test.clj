(ns clojurewerkz.ogre.filter.back-test
  (:use [clojure.test])
  (:require [clojurewerkz.ogre.core :as q]
            [clojurewerkz.ogre.tinkergraph :as g]
            [clojurewerkz.ogre.test-util :as u]))

(deftest test-transform-step
  (testing "test_g_v1_out_backX1X"
    (let [g (g/use-new-tinker-graph!)
          vs (q/query (g/find-by-id g 1)
                      q/-->
                      (q/back 1)
                      q/into-vec!)]
      (is (= #{"marko"} (u/get-names-set vs)))
      (is (= 1 (count vs)))))
  
  (testing "test_g_v1_asXhereX_out_backXhereX()"
    (let [g (g/use-new-tinker-graph!)
          vs (q/query (g/find-by-id g 1)
                      (q/as "here")
                      q/-->
                      (q/back-to "here")
                      q/into-vec!)]
      (is (= #{"marko"} (u/get-names-set vs)))
      (is (= 1 (count vs)))))

  (testing "test_g_v4_out_filterXlang_eq_javaX_backX1X"
    (let [g (g/use-new-tinker-graph!)
          vs (q/query (g/find-by-id g 4)
                      q/-->
                      (q/filter #(= "java" (g/get-property :lang % )))
                      (q/back 1)
                      q/into-vec!)]
      (is (= #{"ripple" "lop"} (u/get-names-set vs)))
      (is (= 2 (count vs)))))

  (testing "test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX()"
    (let [g (g/use-new-tinker-graph!)
          vs (q/query (g/find-by-id g 4)
                      q/-->
                      (q/as "here")
                      (q/filter #(= "java" (g/get-property :lang % )))
                      (q/back-to "here")
                      q/into-vec!)]
      (is (= #{"ripple" "lop"} (u/get-names-set vs)))
      (is (= 2 (count vs)))))

  (testing "test_g_v4_out_asXhereX_filterXlang_eq_javaX_backXhereX_propertyXnameX"
    (let [g (g/use-new-tinker-graph!)
          names (q/query (g/find-by-id g 4)
                         q/-->
                         (q/as "here")
                         (q/filter #(= "java" (g/get-property :lang % )))
                         (q/back-to "here")
                         (q/property :name)
                         q/into-set!)]
      (is (= #{"ripple" "lop"} names))
      (is (= 2 (count names))))))