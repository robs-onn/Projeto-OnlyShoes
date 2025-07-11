/** @type {import('tailwindcss').Config} */
module.exports = {
  
  content: [
    './src/main/resources/templates/client/**/*.html',
    './src/main/resources/templates/layout/**/*.html'
  ],

  theme: {
    extend: {
      colors: {
        'orange': {
          '500': '#ff6600',
          '600': '#e65c00',
        },
      },
    },
  },
  plugins: [],
}