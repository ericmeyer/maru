(ns maru.test.common.game.board.core
  (:refer-clojure :exclude [empty])
  (:use [maru.common.game.board.core] :reload)
  (:use [clojure.test]))

(deftest convert-x-min-y-min-to-pos
  (reset 9)
  (is (= 81 (to-pos 0 0))))

(deftest convert-x-one-y-min-to-pos
  (reset 9)
  (is (= 82 (to-pos 1 0))))

(deftest convert-x-max-y-min-to-pos
  (reset 9)
  (is (= 89 (to-pos 8 0))))

(deftest convert-x-max-y-one-to-pos
  (reset 9)
  (is (= 80 (to-pos 8 1))))

(deftest convert-x-max-y-max-to-pos
  (reset 9)
  (is (= 17 (to-pos 8 8))))

(deftest convert-pos-min-to-x
  (reset 9)
  (is (= 0 (to-x 0))))

(deftest convert-pos-one-to-x
  (reset 9)
  (is (= 1 (to-x 1))))

(deftest convert-pos-max-to-x
  (reset 9)
  (is (= 8 (to-x 8))))

(deftest convert-pos-max-plus-one-to-x
  (reset 9)
  (is (= 0 (to-x 9))))

(deftest convert-pos-max-times-max-to-x
  (reset 9)
  (is (= 8 (to-x 80))))

(deftest convert-pos-min-to-y
  (reset 9)
  (is (= 8 (to-y 0))))

(deftest convert-pos-one-to-y
  (reset 9)
  (is (= 8 (to-y 1))))

(deftest convert-pos-max-to-y
  (reset 9)
  (is (= 8 (to-y 8))))

(deftest convert-pos-max-plus-one-to-y
  (reset 9)
  (is (= 7 (to-y 9))))

(deftest convert-pos-max-times-max-to-y
  (reset 9)
  (is (= 0 (to-y 80))))

(deftest play-at-pos-with-black
  (is (= black (nth (play empty 0 black) 0))))

(deftest play-white-at-pos
  (is (= white (nth (play-white empty 0) 0))))

(deftest play-multiple-moves
  (let [current-board (reduce #(play-white %1 %2) empty '(0 1))]
    (is (= 2 (nth current-board 0)))
    (is (= 2 (nth current-board 1)))))

(deftest reset-board-with-size-nine
  (reset 9)
  (is (= 81 (count empty))))

(deftest check-color-at-pos
  (is (= white (color (play-white empty 0) 0))))

(deftest check-pos-out-of-bound
  (reset 9)
  (is (= true (out-of-bound -1))))

(deftest convert-string-to-position
  (reset 19)
  (is (= 140 (pos-from-string "H12"))))

(deftest convert-string-to-color
  (is (= white (string-to-color "W")))
  (is (= white (string-to-color "w")))
  (is (= black (string-to-color "B")))
  (is (= black (string-to-color "b"))))
