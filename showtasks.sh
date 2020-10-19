#!/usr/bin/env bash

start_runcrud() {
  /Users/marcin/Desktop/tasks/runcrud.sh start
  end
}

stop_runcrud() {
  /Users/marcin/Desktop/tasks/runcrud.sh start
}

fail() {
  echo "There were errors with calling runcrud"
}

end() {
  echo "Work is finished runcrud is called"
}

open_website() {
  open http://localhost:8080/crud/v1/task/getTasks
}

if start_runcrud; then
  open_website
  echo "Success , today is your lucky day"
else
  stop_runcrud
  echo "Sorry, cannot call runcrud"
  fail
fi
