const baseUrl = `${process.env.REACT_APP_API_URL}/todos`;

export const loadTodos = () => {
  return fetch(baseUrl).then((response) => response.json());
};

export const getToDos = (id) => {
  return fetch(`${baseUrl}/${id}`).then((response) => response.json());
};

export const createTodo = (todo) => {
  return fetch(baseUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      title: todo.title,
      completed: todo.completed,
    }),
  }).then((response) => response.json());
};

export const updateTodo = (todo) => {
  return fetch(`${baseUrl}/${todo.id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      id: todo.id,
      title: todo.title,
      completed: todo.completed,
    }),
  }).then((response) => response.json());
};

export const deleteTodo = (id) => {
  return fetch(`${baseUrl}/${id}`, {
    method: "DELETE",
  }).then((response) => response.json());
};
