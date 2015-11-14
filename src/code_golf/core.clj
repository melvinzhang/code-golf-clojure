(ns code-golf.core
  (:gen-class))

; invert a binary string
(defn q1 [s]
  (apply str (map #(+ 1 (- 48 (int %))) s)))

; test if input string is abbccc...z^26
(defn q2 [s]
  (if (->> (range 1 27)
           (mapcat #(repeat % %))
           (map #(char (+ 96 %)))
           (apply str)
           (= s )) 
      42 
      -1))

; iteratively simplify a binary string
; incomplete
(defn b [s]
  (reverse (map #(- (int %) 48) s)))

(defn t [l]
  (reduce + (map * (iterate #(* 2 %) 1) l)))

(defn q3 [s]
  (str (t (b s))))

; mexican wave
(defn q4 [] 
  (let [alpha (map #(char (+ 97 %)) (range 26)) 
        a2z (map (fn [x] {x (char (- (int x) 32))}) alpha) 
        a2a (concat a2z (rest (reverse a2z)))]
    (as-> a2a $
         (map #(replace % alpha) $)
         (map #(apply str %) $)
         (doseq [l $] (println l)))))
