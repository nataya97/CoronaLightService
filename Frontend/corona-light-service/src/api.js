import axios from "axios";

export default axios.create({
    baseURL: 'http://localhost:1433',
    headers: {
        "Access-Control-Allow-Origin": '*',
        'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE',
        "Content-type": "application/json",
        "Authorization": "Bearer" + 'token'
    },
});
