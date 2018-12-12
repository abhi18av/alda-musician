(require '[alda.core :refer :all])

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





(alda "play" "-c" "piano: g+ f+ e+ d+ c++")

(alda "play" "-c" "piano: o4 c4 c8 c c16 c c c c32 c c c c c c c | c1")

(alda "play" "-c" "piano: r2 c | r4 c r8 c r4")

(alda "play" "-c" "trombone: o2 c4.. d16 e-8 r c r")

(alda "play" "-c" "piano: o2 g+1~1")

(alda "play" "-c" "piano: o4 c1/e-/g/b")

(alda "play" "-c" "piano: o4 c1/e/g/>c4 < b a g | < g+1/b/>e")

(alda "play" "-c" "V1: o5 c4 < b a g | e1")
(alda "play" "-c" "V2: o4 c1/e/g | < g+/b")

(alda "play" "-c" "bassoon: o2 d8 e (quant 30) f+ g (quant 99) a2")

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
