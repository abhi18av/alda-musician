(require '[alda.core :refer :all])

(alda "up")


(alda "play" "-c" "piano: c d e f")


(play!
 (tempo 120)
 (part "piano")
 (octave! 4)
  (note (pitch :c))
  (note (pitch :d ))
  (note (pitch :e ))
  (note (pitch :f)))



;;;;;;;;


(alda "play" "-c" "piano: g a b > c")


(play!
 (tempo 120)
 (part "piano")
 (octave 4)
 (note (pitch :g))
 (note (pitch :a ))
 (note (pitch :b ))
 (octave :up)
 (note (pitch :c)))


;;;;;;;;



(alda "play" "-c" "piano: o0 c > c > c > c > c > c > c > c > c > c")

(play!
 (tempo 120)
 (part "piano")
 (octave 0)
 (note (pitch :c))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c ))
 (octave :up)
 (note (pitch :c)))





(alda "play" "-c" "piano: o4 c < b- a g f+")

(play!
 (tempo 120)
 (part "piano")
 (octave 4)
 (note (pitch :c))
 (octave :down)
 (note (pitch :b :flat ))
 (note (pitch :a ))
 (note (pitch :g ))
 (note (pitch :f :sharp)))



;;;;;

(alda "play" "-c" "piano: g+ f+ e+ d+ c++")

(play!
 (tempo 120)
 (part "piano")
 (octave 4)
 (note (pitch :g :sharp))
 (note (pitch :f :sharp))
 (note (pitch :e :sharp))
 (note (pitch :d :sharp))
 (note (pitch :c :sharp :sharp)))




(alda "play" "-c" "piano: o4 c4 c8 c c16 c c c c32 c c c c c c c | c1")


(play!
 (tempo 120)
 (part "piano")
 (octave 4)
 (note (pitch :c) (duration (note-length 4)))
 (note (pitch :c) (duration (note-length 8)))
 (note (pitch :c))
 (note (pitch :c) (duration (note-length 16)))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c) (duration (note-length 32)))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
 (note (pitch :c))
;; Bar lines are optional in Alda ( | )
 (note (pitch :c) (duration (note-length 1))))


;;;;;;;



(alda "play" "-c" "piano: r2 c | r4 c r8 c r4")


(play!
 (tempo 120)
 (part "piano")
 (octave 4)
 (note (pitch :r) (duration (note-length 2)))
 (note (pitch :c))
 (barline)
 (note (pitch :r) (duration (note-length 4)))
 (note (pitch :c))
 (note (pitch :r) (duration (note-length 8)))
 (note (pitch :c))
 (note (pitch :r) (duration (note-length 4))))



;;;;

(alda "play" "-c" "trombone: o2 c4.. d16 e-8 r c r")

(play!
 (tempo 120)
 (part "trombone")
 (octave 2)
; (voice 1)
; (panning 25)
 (note (pitch :c) (duration (note-length 4 {:dots 2})))
 (note (pitch :d) (duration (note-length 16)))
 (note (pitch :e :flat) (note-length 8)
 (note (pitch :r))
 (note (pitch :c))
 (note (pitch :r))))


;;;;


(alda "play" "-c" "piano: o2 g+1~1")

(play!
 (tempo 120)
 (part "piano")
 (octave 2)
 (note (pitch :g :sharp) (duration (note-length 1)) :slur))


;;;;


(alda "play" "-c" "piano: o4 c1/e-/g/b")

(play!
 (tempo! 120)
 (part "piano")
 (octave! 4)
 (chord
  (note (pitch :c)
        (duration (note-length 1)))
  (note (pitch :e :flat))
  (note (pitch :g ))
  (note (pitch :b #_:natural))))

;;;;



(alda "play" "-c" "piano: o4 c1/e/g/>c4 < b a g | < g+1/b/>e")

(play!
 (tempo! 120)
 (part "piano")
 (octave 4)
 (chord
 (note (pitch :c)
        (duration (note-length 1)))
  (note (pitch :e ))
  (note (pitch :g ))
  (octave :up))
 (note (pitch :c)
       (note-length 4))
 (octave :down)
 (note (pitch :b ))
 (note (pitch :a ))
 (note (pitch :g )))


;;;;



(alda "play" "-c" "V1: o5 c4 < b a g | e1")

(play!
 (tempo! 120)
 (part "piano")
 (voice 1)
 (octave 5)
 (note (pitch :c) (note-length 4))
 (octave :down)
 (note (pitch :b ))
 (note (pitch :a ))
 (note (pitch :g ))
 (barline)
 (note (pitch :e) (note-length 1)))



(alda "play" "-c" "V2: o4 c1/e/g | < g+/b")



(play!
 (tempo! 120)
 (part "piano")
 (voice 2)
 (octave 4)
 (chord
 (note (pitch :c) (note-length 1))
 (note (pitch :e ))
 (note (pitch :g )))
 (barline)
 (octave :down)
 (chord
  (note (pitch :g :sharp))
  (note (pitch :b))))









(alda "play" "-c" "bassoon: o2 d8 e (quant 30) f+ g (quant 99) a2")

(play!
; (tempo 120)
 (part "bassoon")
 (octave 2)
 (note (pitch :d) (note-length 8))
 (note (pitch :e ))
 (quant 30)
 (note (pitch :f :sharp))
 (note (pitch :g ))
 (quant 99)
 (note (pitch :a) (note-length 2)))



(alda "play" "-c" "bassoon: o2 d8 e (quant 30) (vol 65) f+ g (quant 99) a2")



(alda "play" "-c" "trumpet:  o4 c8 d e f g a b > c4.")
(alda "play" "-c" "trombone: o3 e8 f g a b > c d e4.")

(alda "play" "-c" "trumpet:  o4 c8 d e f g")
(alda "play" "-c" "trombone: o3 e8 f g a b")

(alda "play" "-c" "trumpet:  a b > c4.")
(alda "play" "-c" "trombone: > c d e4.")



(alda "play" "-c" "trumpet:  (tempo 200) o4 c8 d e f g a b > c4.")
(alda "play" "-c" "trombone: o3 e8 f g a b > c d e4.")
(alda "play" "-c" "trombone: o3 e8 f g a b > c d e4.")




(alda "play" "-c" "trumpet:  (tempo! 200) o4 c8 d e f g a b > c4.")
(alda "play" "-c" "trombone: o3 e8 f g a b > c d e4.")



(alda "play" "-c" "trumpet:  o4 c8 d e f g a b > %last-note c4.~2")
(alda "play" "-c" "trombone: o3 e8 f g a b > c d e4.~2")
(alda "play" "-c" "tuba: @last-note o2 c4.~2")
