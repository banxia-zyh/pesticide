<template>
    <div>
        <input ref="searchInput" v-model="input"/>
        <ul ref="selectList">
            <li :key="index" v-for="(item, index) in list">
                {{item}}
            </li>
        </ul>
    </div>
</template>

<script>

    export default {
        name: 'SearchInput',
        mounted () {
            let self = this
            document.getElementById('app').onclick = event => {
                if (event.target !== self.$refs.searchInput) {
                    self.$refs.selectList.style.visibility = 'hidden'
                }
            }
        },
        props: {
            list: []
        },
        data () {
            return {
                input: ''
            }
        },
        watch: {
            input () {
                this.$emit('input-change', this.input)
            },
            list () {
                if (this.list !== null && this.list.length > 0) {
                    this.$refs.selectList.style.visibility = 'visible'
                }
            }
        }
    }
</script>

<style scoped>
    input {
        width: 200px;
        border: 1px solid grey;
        padding: 0 2px;
        line-height: 1.5rem;
        box-sizing: border-box;
        outline: none;
    }

    ul {
        margin: 0;
        width: 200px;
        padding: 0;
        list-style: none;
        box-sizing: border-box;
        padding: 1px;
        border: 1px solid;
        border-color: grey;
    }

    li {
        line-height: 1.5rem;
        padding: 0 0 0 1px;
    }

    li:hover {
        background-color: grey;
    }

    .section {
        top: 30%;
        left: 50%;
        position: absolute;
        margin-left: -100px;
    }
</style>
