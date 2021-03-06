//
// Created by lee on 16-7-20.
//

#ifndef REENGINE_MATCH_H
#define REENGINE_MATCH_H

#include <unordered_map>
#include <set>
#include "NFA.h"

void match(NFA*, const std::string&);//using nfa to match a certain string

void match(const std::string patern, const std::string& toMatch);

void epsilon_closure(State* state,set<State*>& ss);

#endif //REENGINE_MATCH_H
