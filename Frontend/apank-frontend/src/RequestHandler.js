import axios from 'axios'

class RequestHandler {

    async postRequest(address, data) {
        let temp

        await axios.post(address, data, {
            headers: {
                'Authorization': 'Bearer ' + JSON.parse(sessionStorage.getItem("user")).token
            }
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
            headers: {
                'Authorization': 'Bearer ' + JSON.parse(sessionStorage.getItem("user")).token
            }
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