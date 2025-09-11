import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  // server: {
  //   proxy: {
  //     '/books': {
  //       target: 'http://localhost:9090',
  //       changeOrigin: true,
  //       // rewrite: (path) => path.replace(/^\/books/, '/books'), // thường không cần rewrite nếu path giống nhau
  //     },
  //   },
  // },
})
