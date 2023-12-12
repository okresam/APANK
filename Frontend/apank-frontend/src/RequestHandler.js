import axios from 'axios'

let headers = { headers: {
    'Authorization': 'Bearer ' + JSON.parse(sessionStorage.getItem("user")).token
} }

class RequestHandler {

    async postRequest(address, data) {
        let temp

        await axios.post(address, data, {
            headers
        })
        .then(response => {
            temp = response.data
        })
        .catch(e => {
            temp = undefined
        })
        return temp
    }

    async getRequest(address) {
        let temp

        await axios.get(address, {
            headers
        })
        .then(response => {
            temp = response.data
        })
        .catch(e => {
            temp = undefined
        })
        return temp
    }
}

export default new RequestHandler();