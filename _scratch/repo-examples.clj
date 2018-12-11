(require '[alda.core :refer :all])
;; TODO: use qualified import in v2.0

(alda "up")

;;;;;;;;;;;;;;;
;; across_the_sea.alda
;;;;;;;;;;;;;;;

;; (tempo! 90)
;; (quant! 95)
;; piano:
;; o5 g- > g- g-/f > e- d-4. < b-8 d-2 | c-4 e- d- d- <b-1/>g-
;; flute:
;; r2 g-4 a- b-2. > d-32~ e-16.~8 < b-2 a- g-1

;;;;;;;;;;;;;;;
;; across_the_sea.clj
;;;;;;;;;;;;;;;


(->str
(play!
 (tempo! 90)
 (quant! 95)

;(alda "play" "-c" " piano: o5 g- > g- g-/f > e- d-4. < b-8 d-2 | c-4 e- d- d- <b-1/>g- ")

(part "piano")
(octave 5)
(note (pitch :g :flat))
(octave :up)
(note (pitch :g :flat))
      (chord
       (note (pitch :g :flat))
       (note (pitch :f #_:natural)))))


#_(alda "play" "-c" "flute: r2 g-4 a- b-2. > d-32~ e-16.~8 < b-2 a- g-1")


(alda "down")


