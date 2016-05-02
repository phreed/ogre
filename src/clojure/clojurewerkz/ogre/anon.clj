(ns clojurewerkz.ogre.anon
  (:refer-clojure :exclude [and count drop filter group-by key key identity iterate loop map max min next not or range repeat reverse shuffle])
  (:require [potemkin :as po]
            [clojurewerkz.ogre.util :as util])
  (:import (org.apache.tinkerpop.gremlin.process.traversal Traversal Compare P Order Pop)
           (org.apache.tinkerpop.gremlin.structure T Column VertexProperty$Cardinality)
           (java.util Iterator)
           (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph GraphTraversal GraphTraversalSource)))

; __ (anonymous GraphTraversal)

(defmacro __
  "Starts a anonymous traversal."
  [xs & body]
   `(-> (apply ~(symbol (str "clojurewerkz.ogre.anon/__" (name (first xs)))) ~(vec (rest xs))) ~@body))

(defn __add-E
  [label]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/addE ^String (util/cast-param label)))

(defn __add-V
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/addV))
  ([label]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/addV ^String (util/cast-param label))))

(defn __aggregate
  [k]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/aggregate k))

(defn __and
  [traversals]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/and (into-array traversals)))

(defn __as
  [step-label & step-labels]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/as step-label (into-array step-labels)))

(defn __barrier
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/barrier))
  ([max-or-consumer]
   (if (instance? clojure.lang.IFn max-or-consumer)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/barrier (util/f-to-consumer max-or-consumer))
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/barrier (int max-or-consumer)))))

(defn __both
  [& labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/both label-array)))

(defn __bothE
  [& labels]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/bothE (util/keywords-to-str-array labels)))

(defn __bothV
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/bothV))

(defn __branch
  [f-or-t]
  (if (instance? Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/branch ^Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/branch (util/f-to-function f-or-t))))

(defn __cap
  [k & ks]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/cap k (into-array ks)))

(defn __choose
  ([f-or-t]
   (if (instance? Traversal f-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/choose ^Traversal f-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/choose (util/f-to-function f-or-t))))
  ([p-or-t true-choice false-choice]
   (if (instance? Traversal p-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/choose ^Traversal p-or-t ^Traversal true-choice ^Traversal false-choice)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/choose (util/f-to-predicate p-or-t) ^Traversal true-choice ^Traversal false-choice))))

(defn __coin
  [prob]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/coin prob))

(defn __constant
  [c]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/constant c))

(defn __count
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/count))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/count scope)))

(defn __cyclic-path
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/cyclicPath))

(defn __dedup
  ([labels]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/dedup (into-array labels)))
  ([scope labels]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/dedup scope (into-array labels))))

(defn __drop
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/drop))

(defn __emit
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/emit))
  ([pred-or-t]
   (if (instance? Traversal pred-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/emit  ^Traversal pred-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/emit  (util/f-to-predicate pred-or-t)))))

(defn __filter
  [pred-or-t]
  (if (instance? Traversal pred-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/filter ^Traversal pred-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/filter (util/f-to-predicate pred-or-t))))

(defn __flat-map
  [f-or-t]
  (if (instance? Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/flatMap ^Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/flatMap (util/f-to-function f-or-t))))

(defn __fold
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/fold))
  ([seed fold-function]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/fold seed (util/f-to-bifunction fold-function))))

(defn __group
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/group))
  ([k]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/group k)))

(defn __group-count
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/groupCount))
  ([k]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/groupCount k)))

(defn __has
  "Allows an element if it has the given property or it satisfies given predicate."
  ([k]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has (util/cast-param k)))
  ([k val-or-pred-or-t]
   (let [arg1 (util/cast-param k)]
     (cond
       (instance? String arg1)
       (cond
         (instance? P val-or-pred-or-t)
         (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^String arg1 ^P val-or-pred-or-t)
         (instance? Traversal val-or-pred-or-t)
         (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^String arg1 ^Traversal val-or-pred-or-t)
         :else (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^String arg1 ^Object val-or-pred-or-t))
       (instance? T arg1)
       (cond
         (instance? P val-or-pred-or-t)
         (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^T arg1 ^P val-or-pred-or-t)
         (instance? Traversal val-or-pred-or-t)
         (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^T arg1 ^Traversal val-or-pred-or-t)
         :else (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^T arg1 ^Object val-or-pred-or-t)))))
  ([label k val-or-pred]
   (let [arg2 (util/cast-param k)
         arg1 (util/cast-param label)]
     (if (instance? P val-or-pred)
       (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^String arg1 ^String arg2 ^P val-or-pred)
       (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/has ^String arg1 ^String arg2 ^Object val-or-pred)))))

(defn __has-id
  [ids]
  (let [id-array (into-array Object ids)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/hasId id-array)))

(defn __has-key
  [ks]
  (let [k-array (util/keywords-to-str-array ks)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/hasKey k-array)))

(defn __has-label
  [labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/hasLabel label-array)))

(defn __id
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/id))

(defn __identity
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/identity))

(defn __in
  [& labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/in label-array)))

(defn __inE
  [& labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/inE label-array)))

(defn __inject
  [args]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/inject (into-array args)))

(defn __inV
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/inV))

(defn __is
  [val-or-pred]
  (if (instance? P val-or-pred)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/is ^P val-or-pred)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/is ^Object val-or-pred)))

(defn __key
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/key))

(defn __label
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/label))

(defn __limit
  ([lim]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/limit lim))
  ([scope lim]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/limit scope lim)))

(defn __local
  [local-traversal]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/local local-traversal))

(defn __loops
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/loops))

(defn __map
  [f-or-t]
  (if (instance? Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/map ^Traversal f-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/map (util/f-to-function f-or-t))))

(defn __match
  [traversals]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/match (into-array traversals)))

(defn __max
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/max))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/max scope)))

(defn __mean
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/mean))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/mean scope)))

(defn __min
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/min))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/min scope)))

(defn __not
  ([not-traversal]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/not not-traversal)))

(defn __optional
  ([opt-traversal]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/optional opt-traversal)))

(defn __or
  [traversals]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/or (into-array traversals)))

(defn __order
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/order))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/order scope)))

(defn __otherV
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/otherV))

(defn __out
  [& labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/out label-array)))

(defn __outE
  [& labels]
  (let [label-array (util/keywords-to-str-array labels)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/outE label-array)))

(defn __outV
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/outV))

(defn __path
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/path))

(defn __project
  [k & ks]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/project k (into-array ks)))

(defn __properties
  [& ks]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/properties (util/keywords-to-str-array ks)))

(defn __property
  [args]
  (if (instance? VertexProperty$Cardinality (first args))
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/property ^VertexProperty$Cardinality (first args) (util/cast-param (second args)) (nth args 3) (util/cast-every-other-param (take-last 3 args)))
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/property ^Object (util/cast-param (first args)) (second args) (util/cast-every-other-param (take-last 2 args)))))

(defn __property-map
  [& ks]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/propertyMap (util/keywords-to-str-array ks)))

(defn __range
  ([low high]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/range low high))
  ([scope low high]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/range scope low high)))

(defn __repeat
  [repeat-traversal]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/repeat repeat-traversal))

(defn __sack
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sack))
  ([sack-op]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sack sack-op))
  ([sack-op ks]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sack sack-op (util/keywords-to-str-array ks))))

(defn __sample
  ([amount]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sample amount))
  ([scope amount]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sample scope amount)))

(defn __select
  ([arg1]
   (if (instance? Column arg1)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/select ^Column arg1)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/select ^String arg1)))
  ([arg1 & args]
   (if (instance? Pop arg1)
     (if (= (clojure.core/count args) 1)
       (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/select ^Pop arg1 (first args))
       (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/select ^Pop arg1 (first args) (second args) (into-array (take-last 2 args))))
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/select ^String arg1 (first args) (into-array (rest args))))))

(defn __side-effect
  [c-or-t]
  (if (instance? Traversal c-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sideEffect ^Traversal c-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sideEffect (util/f-to-consumer c-or-t))))

(defn __simple-path
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/simplePath))

(defn __store
  [k]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/store k))

(defn __subgraph
  [k]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/subgraph k))

(defn __sum
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sum))
  ([scope]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sum scope)))

(defn __tail
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/tail))
  ([arg1]
   (if (instance? ^Scope arg1)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sack ^Scope arg1)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/sack (long arg1))))
  ([scope lim]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/tail scope lim)))

(defn __time-limit
  [lim]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/timeLimit lim))

(defn __times
  [loops]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/times loops))

(defn __to
  [direction & labels]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/to direction (util/keywords-to-str-array labels)))

(defn __to-E
  ([direction & labels]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/toE direction (util/keywords-to-str-array labels))))

(defn __to-V
  ([direction]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/toV direction)))

(defn __tree
  ([]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/tree))
  ([k]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/tree k)))

(defn __unfold
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/unfold))

(defn __union
  [traversals]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/union (into-array traversals)))

(defn __until
  [pred-or-t]
  (if (instance? Traversal pred-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/until ^Traversal pred-or-t)
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/until (util/f-to-predicate pred-or-t))))

(defn __midV
  "A mid-traversal V known in Gremlin-Java as just V()"
  [& ids]
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/V (into-array ids)))

(defn __value
  []
  (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/value))

(defn __value-map
  [& args]
  (if (clojure.core/and (clojure.core/not (empty? args)) (instance? Boolean (first args)))
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/valueMap (first args) (util/keywords-to-str-array (rest args))))
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/valueMap (util/keywords-to-str-array args)))

(defn __values
  [& ks]
  (let [k-array (util/keywords-to-str-array ks)]
    (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/values k-array)))

(defn __where
  ([p-or-t]
   (if (instance? Traversal p-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/where ^Traversal p-or-t)
     (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/where ^P p-or-t)))
  ([k p]
   (org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__/where k p)))
