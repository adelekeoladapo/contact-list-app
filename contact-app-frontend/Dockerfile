FROM node:12.7-alpine AS build
RUN mkdir -p /app
WORKDIR /app
COPY package*.json /app/
RUN npx npm-force-resolutions
RUN npm i
COPY . /app
RUN npm run build


FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
RUN rm -rf /usr/share/nginx/html/*
COPY --from=build /app/dist/contact-app-frontend /usr/share/nginx/html
RUN cp /usr/share/nginx/html/index.html /usr/share/nginx/html/404.html
