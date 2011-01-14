(ns maru.common.game.rule-spec
  (:use [speclj.core]
        [maru.common.game.rule]
				[maru.common.board.core])
  (:require [maru.common.game.rule]))

(describe "Rules find all legal moves"
	(it "has all moves for an empty board"
		(reset 9)
		(should= 81 (count (find-all-legal board white))))
	(it "filters a white move for white"
		(reset 9)
		(def new-board (play 1 white))
		(prn (find-all-legal new-board white))
		(should= 80 (count (find-all-legal new-board white))))
	(it "filters a black move for white"
		(reset 9)
		(def new-board (play 1 black))
		(should= 80 (count (find-all-legal new-board white))))
	(it "filters a white move for black"
		(reset 9)
		(def new-board (play 1 white))
		(should= 80 (count (find-all-legal new-board black))))
	(it "filters a black move for black"
		(reset 9)
		(def new-board (play 1 black))
		(should= 80 (count (find-all-legal new-board black))))
)