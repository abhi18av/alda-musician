(require '[alda.core :refer :all])

(play!
 (part "piano")
 (for [notes [[:c :e :g] [:c :f :a] [:c :e :g]]]
   (apply chord (map #(note (pitch %)) notes))))



;; conjure a guitar
(play! (part "guitar"))

;; play a few notes on the guitar
(play!
 (note (pitch :e) (note-length 8))
 (note (pitch :f :sharp))
 (note (pitch :g)))

;; play a few notes, still on the guitar
(play!
 (note (pitch :a))
 (note (pitch :b) (note-length 2)))


;;;;;;; EXAMPLES

#!/usr/bin/env clojure
;; vim: ft=clojure

(require '[alda.core :refer :all])

(comment
  "Clapping Music (1972)
   for two performers

   Steve Reich

   sheet music:
   https://sites.ualberta.ca/~michaelf/SEM-O/SEM-O_2014/Steve's%20piece/clapping_reich.jpg")

(def pattern
  (let [clap "o2 d+8"
        rest (pause (duration (note-length 8)))]
    [clap clap clap rest clap clap rest clap rest clap clap rest]))

(defn shift [n pattern]
  (take (count pattern) (drop n (cycle pattern))))

(play!
 (tempo! 172)

 (part "midi-percussion")

 (voice 1)
 (repeat 13
         (repeat 12 pattern))

 (voice 2)
 (for [n (range 13)]
   (repeat 12 (shift n pattern))))

(println "Press Ctrl-C to stop & exit.")

;; (.addShutdownHook (Runtime/getRuntime)
;;                   (Thread. #(stop!)))

(stop!)

;;;;;;

;; #!/usr/bin/env clojure
;; vim: ft=clojure

(require '[alda.core :refer :all])

(def REST-RATE 0.15)
(def MS-LOWER 30)
(def MS-UPPER 3000)
(def MAX-OCTAVE 8)

(defn random-note
  "Returns a random note in a random octave with a random duration in
  milliseconds.

  May randomly return a rest with a random duration in milliseconds, instead."
  []
  (let [ms (ms (rand-nth (range MS-LOWER MS-UPPER)))]
    (if (< (rand) REST-RATE)
      (pause (duration ms))
      (let [o (rand-int (inc MAX-OCTAVE))
            n [(keyword (str (rand-nth "abcdefg")))
               (rand-nth [:sharp :flat :natural])]]
        [(octave o)
         (note (apply pitch n) (duration ms))]))))

(->str
(play!
  (part "midi-electric-piano-1")
  (panning 25)
  (repeatedly 50 random-note)

  ;; (part "midi-timpani")
  ;; (panning 50)
  ;; (repeatedly 50 random-note)

  ;; (part "midi-celesta")
  ;; (panning 75)
  #_(repeatedly 50 random-note)))

(println "Press Ctrl-C to stop & exit.")

(.addShutdownHook (Runtime/getRuntime)
  (Thread. #(stop!)))

;;;;;;;;;;;

;; #!/usr/bin/env clojure
;; vim: ft=clojure

(require '[alda.core :refer :all])

(play!
 (tempo! 180)

 (part "piano")

 (for [mode [:ionian :dorian :phrygian :lydian :mixolydian :aeolian :locrian]]
   [(key-sig [:c mode])
    "o4 c4 d8 e f g a b > c1"]))

(println "Press Ctrl-C to stop & exit.")

(.addShutdownHook (Runtime/getRuntime)
                  (Thread. #(stop!)))


;;;;;;

(->str
(play!
 (part "accordion")
       (note (pitch :c) (duration (note-length 8)))
       (note (pitch :d))
       (note (pitch :e :flat))
       (note (pitch :f))
       (note (pitch :g))
       (note (pitch :a :flat))
       (note (pitch :b))
       (octave :up)
       (note (pitch :c))))

;;;;;;


(play!
 (tempo! 180)

 (part "piano")
 (note (pitch :e :flat))
; (octave :down)
 (note (pitch :d)))


;;;;;

(play!
 (tempo! 120)
 (part "cello")
 (note (pitch :e )
       (duration (note-length 8)))
 (note (pitch :f ))
 (note (pitch :g )))




;;;;;;;;;;;;;;
;; Qualified import
;;;;;;;;;;;;;;

(require '[alda.core :as alda])

(println (alda/alda "version"))

(println (alda/alda "status"))


